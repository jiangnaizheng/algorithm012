学习笔记
1.深度优先和广度优先

深度优先：递归  栈模拟递归

广度优先：水滴 水波纹   队列模拟

模板：

深度优先

  **public** List<List<Integer>> levelOrder(TreeNode root) {

​    List<List<Integer>> allResults = **new** ArrayList<>();

​    **if**(root==**null**){

​      **return** allResults;

​    }

​    travel(root,0,allResults);

​    **return** allResults;

  }

  **private** **void** **travel**(TreeNode root,**int** level,List<List<Integer>> results){

​    **if**(results.size()==level){

​      results.add(**new** ArrayList<>());

​    }

​    results.get(level).add(root.val);

​    **if**(root.left!=**null**){

​      travel(root.left,level+1,results);

​    }

​    **if**(root.right!=**null**){

​      travel(root.right,level+1,results);

​    }

  }

广度优先：

//Java

**public** **class** **TreeNode** {

​    **int** val;

​    TreeNode left;

​    TreeNode right;

​    TreeNode(**int** x) {

​        val = x;

​    }

}

**public** List<List<Integer>> levelOrder(TreeNode root) {

​    List<List<Integer>> allResults = **new** ArrayList<>();

​    **if** (root == **null**) {

​        **return** allResults;

​    }

​    Queue<TreeNode> nodes = **new** LinkedList<>();

​    nodes.add(root);

​    **while** (!nodes.isEmpty()) {

​        **int** size = nodes.size();

​        List<Integer> results = **new** ArrayList<>();

​        **for** (**int** i = 0; i < size; i++) {

​            TreeNode node = nodes.poll();

​            results.add(node.val);

​            **if** (node.left != **null**) {

​                nodes.add(node.left);

​            }

​            **if** (node.right != **null**) {

​                nodes.add(node.right);

​            }

​        }

​        allResults.add(results);

​    }

​    **return** allResults;

}

2.贪心算法

每一步都采取当前状态下的最好或最优解，从而希望导致全局最好或最优的算法；（工程和生活问题一般不能得到最优解）

解决问题：图中的最小生成树，哈夫曼编码等

如果一个问题可以用贪心算法解决，那么贪心算法一般是解决这个问题的最后解；

贪心算法和动态规划区别在与不能回退；

3.二分查找

 前提：1.目标单调性；2.有上下界；3.能够通过索引访问

模板：

**public** **int** **binarySearch**(**int**[] array, **int** target) {

​    **int** left = 0, right = array.length - 1, mid;

​    **while** (left <= right) {

​        mid = (right - left) / 2 + left;

​        **if** (array[mid] == target) {

​            **return** mid;

​        } **else** **if** (array[mid] > target) {

​            right = mid - 1;

​        } **else** {

​            left = mid + 1;

​        }

​    }

​    **return** -1;

}



