public class Tree {

    class Element {
        protected int data;
        protected Element left;
        protected Element right;

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
            //System.out.println("Econstructor:\t" + Integer.toHexString(hashCode()));
        }

        @Override
        protected void finalize() /*throws Throwable*/ {
            // super.finalize();
            // System.out.println("EDestructor:\t" + Integer.toHexString(hashCode()));
        }
    }

    protected Element root;

    public Element getRoot() {
        return root;
    }


    public Tree() {
        this.root = null;
        // System.out.println("TConstructor:\t" + Integer.toHexString(hashCode()));
    }

    public Tree(Element root) {
        this.root = root;
    }

    public double avg() {
        return (double) sum() / count();
    }

    public void insert(int data) {
        insert(data, root);
    }

    private void insert(int data, Element root) {
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

    public void print() {
        print(root);
        System.out.println();
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

    public int maxValue() {
        return maxValue(root);

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

    public int minValue() {
        return minValue(root);

    }

    public int sum() {
        return sum(root);
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
   /* public void erase(int data) {
        erase(root, data);
    }*/

    /* public void erase (int data,Element root) {
         if (root == null)
             return;
         if (data == root.data) {
             if(root.left == root.right) {
                 root = null;
                 System.gc();
             }
             else {

             }
         }
     }*/
    public void erase(int Data)
    {
        erase(Data, root, null);
    }
    private void erase(int data, Element root, Element parent) {
        if (root == null) return;
        ;
        erase(data, root.left, root);
        erase(data, root.right, root);
        if (data == root.data) {
            if (root.left == root.right) {
                root = null;
                if (parent != null) {
                    if (data == parent.left.data) parent.left = null;
                    if (data == parent.right.data) parent.right = null;
                }
                System.gc();
            } else {
                if (count(root.left) > count(root.right)) {
                    root.data = maxValue(root.left);
                    erase(maxValue(root.left), root.left, root);
                } else {
                root.data = minValue(root.right);
                erase(maxValue(root.right), root.right, root);
            }
        }
    }

}

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
       System.gc();
    }

    public int count (Element root) {
        if (root == null)
            return 0;
        else
            return root == null ? 0 : count(root.left) + count(root.right) + 1;
    }

    public int count(){
        return count(root);
    }
    public int depth(Element root) {
        if (root == null) {
            return 0;
        } //else
            int l_d = depth(root.left) + 1;
            int r_d = depth(root.right) + 1;
           // return depth(root.left) > depth(root.right) ? depth(root.left) +1 : depth(root.right) +1;
        return l_d > r_d ? l_d : r_d;
    }
    public int depth() {
    return depth(root);
    }
    public void printDepth(Element root)  {
        if (root == null)
            return;
        if (root.left == root.right)
            System.out.printf("[ %d : %s - %s ]", root.data, null, null);
        if (root.left == null && root.right != null)
            System.out.printf("[ %d : %s - %s ]", root.data, null, root.right.data);
        if (root.left != null && root.right == null)
            System.out.printf("[ %d : %s - %s ]", root.data, root.left.data, null);
        if (root.left != null && root.right != null)
            System.out.printf("[ %d : %s - %s ]", root.data, root.left.data, root.right.data);
            printDepth(root.left);
            printDepth(root.right);

    }
    public void printDepth () {
       printDepth(root);
    }
}


