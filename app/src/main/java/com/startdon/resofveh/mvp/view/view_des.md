<H1> viwe 层说明 </H1>

该view层的主要功能就是将我们的Activity 界面进行绑定，

让我们将activty 整体看成可以操作的整体View，这也是MVP模式的核心模块。

该层的功能模块也是需要自己创建（interface）在创建时注意一点：

1. `extends BaseView`
2. 构建Activity需要方法。

在Activity中使用方法注意以下：
1. `implements` View层
2.  重写你定义View层的方法。


具体可以参考TestView 


