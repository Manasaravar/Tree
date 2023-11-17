public class Tree {

    class Element {
        int data;
        private Element left;
        private Element right;

        public Element getLeft() {
            return left;
        }

        public Element getRight() {
            return right;
        }

        public Element(int data, Element left, Element right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Element(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            System.out.println("Econstructor:\t" + Integer.toHexString(hashCode()));
        }

        @Override
        protected void finalize() /*throws Throwable*/ {
            // super.finalize();
            System.out.println("RDestructor:\t" + Integer.toHexString(hashCode()));
        }
    }

    private Element root;

    public Element getRoot() {
        return root;
    }


    public Tree() {
        this.root = null;
        System.out.println("TConstructor:\t" + Integer.toHexString(hashCode()));
    }

    public Tree(Element root) {
        this.root = root;
    }

    public void insert(int data, Element root) {
        if (this.root == null)
            this.root = new Element(data);
        if (root == null)
            return;
        if (data < root.data) {
            if (root.left == null)
                root.left = new Element(data);
            else insert(data, root.left);
        } else {
            if (root.right == null)
                root.right = new Element(data);
            else
                insert(data, root.right);
        }
    }

    public void print(Element root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.data + "\t");
        print(root.right);
    }

    public int maxValue(Element root) {
        if (root == null) {
            return 0;
        } else {
            int max;
            if (root.right == null)
                max = root.data;
            else max = maxValue(root.right);
            return max;
        }
    }

    public int minValue(Element root) {
        if (root == null) {
            return 0;
        } else {
            return (root.left == null ? root.data : minValue(root.left));
        }
/*        if (root.left == null)
            return root.data;
        else return minValue(root.left);*/
/*        int min;
        if (root.left == null) min = root.data;
        else min = minValue(root.left);
        return min;*/
    }

    public int sum(Element root) {
        if (root == null) {
            return 0;
        } else {
            return root == null ? 0 : sum(root.left) + sum(root.right) + root.data;
        }
       /* if (root == null) return 0;
        else return  sum(root.left) + sum(root.right) + root.data;*/
         /*int summa = root.data;
         if (root.left != null)
             summa = summa + sum(root.left);
         if (root.right != null)
             summa = summa + sum(root.right);
         return summa;*/
    }

/*        public int sum() {

            if (root == null)
                return 0;
            else
                return root == null ? 0 : sum() + root.data;
            }*/

    public Element erase (Element root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = erase(root.left, data);
        } else if (data > root.data)
            root.right = erase(root.right, data);

        else {
            if (root.left != null && root.right != null) {
                Element minRoot = root;
                while (root.right != null) {
                    minRoot = root.left;
                }
                int min = minRoot.data;

                root.data = min;
                root.right = minRoot.right;

                root.right = erase(root.right, min);
            }

            else if (root.left != null) {
                root = root.left;
            }

            else if (root.right != null) {
                root = root.right;
            }

            else
                root = null;
        }
        return root;
    }

    public void clear() {
        root = null;

        System.out.println("ListClear:\t" + Integer.toHexString(this.hashCode()));
    }



    public int count (Element root) {
        if (root == null)
            return 0;
        else
            return root == null ? 0 : count(root.left) + count(root.right) + 1;

    }

    }


