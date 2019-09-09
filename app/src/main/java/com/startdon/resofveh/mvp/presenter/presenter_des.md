<H1> presenter 层说明 </H1>

该层需要自己实现功能模块presenter  来实现View 层（Activity界面）
进行桥接 同时该层还要完成与Model层的桥接，相当于Presenter层是怎个
MVP 模式的桥梁。

在自己创建presenter (class) 时需要注意2点

1. `extends BasePresenter`
2. BasePresenter 中的泛型 是你自己需要实现的View层

**在开发中需要注意以下：**

1. 通过 `ModelImp  modelimp =new Model` 来实例化Model 使得 Presenter 能够
调取 Model 中的方法

2. 通过自己构建需要传传递的方法来实现与View 层进行交互。



具体用法参考 TestPresenter