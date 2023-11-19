public class UniqueTree extends Tree{
    public void insert (int data) {
        insert(data,root);
    }
    private void insert (int data, Element root) {
        if (this.root == null)
            this.root = new Element(data);
        if (root == null)
            return;
        if (data < root.data) {
            if (root.left == null)
                root.left = new Element(data);
            else insert(data, root.left);
        } else if (data > root.data) {
            if (root.right == null)
                root.right = new Element(data);
            else
                insert(data, root.right);
        }
    }
}
