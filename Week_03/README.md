学习笔记
1.递归 递归栈 (剥洋葱)

递归代码模板

public void recursion(int level,int param1) {

if (level > MAX_LEVEL):

 递归终止条件

return;

process(level,param);   处理当前层的逻辑

recursion(level+1,newParam) ; 下探到下一层

清理当前层
}

思维要点：

1.不要人肉递归

2.找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）

3.数学归纳法思维
 
2.分治和回溯  特殊的递归  本质是找重复性 
分治 把复杂问题拆分为重复子问题；
回溯 采用试错的思想，分布解决一个问题；

