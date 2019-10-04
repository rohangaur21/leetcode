package tree;

public class BTMaxOnEachLevel {
}



    public List<Integer> getMaxOnEachLevel (BinaryTreeNode root){
        if(root ==null ) return Collections.emptylist();
        List<Integer> results = new ArrayList<>();
        int max;

        List <BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
        List <BinaryTreeNode> newlist = new ArrayList<BinaryTreeNode>();
        newlist.add(root);
        while(true){
            max = Integer.MIN_VALUE;
            for(BinaryTreeNode n: list){
                if(max<=n.data){
                    max=n.data;
                }
                if(node.right != null){
                    newlist.add(node.right);
                }
                if(node.left !=null)
                    newlist.add(node.left);
            }}
        results.add(max);
        list=newlist;
        newlist = new ArrayList<>;
    }
}
return results;