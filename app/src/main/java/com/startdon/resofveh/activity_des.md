<H1> Activity 绑定mvp说明 </H1>


activity 中如何与View层presenter层进行桥接。

在开发过程中我们直接创建需要的activity创建时注意以下：

1. `implements View ` 实现implements 这样view才能与activity结合
2. 界面 extends BaseActivity 、如果是Fragment extends  BaseFragment
3. 重新方法，getPresenter() 方法需要对应你操作的Presenter 

例如：<br>
`getLayoutId` <br>
`initEventAndData` <br>
`getPresenter ` <br>
...

4. 与Presenter 交互时通过 mPresenter 方式调取Presenter中的方法

例如：


`  ((TestPresenter) mPresenter).testMetdod(this, "test1", "test2");`



具体可以参考TestActivity 