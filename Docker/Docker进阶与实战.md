Docker进阶与实践

# 第一章 Docker简介

## 1.1 引言

1）Docker并没有传统虚拟化中的Hypervisor层，又称虚拟机监视器（virtual machine monitor）；

2）在通信上，并不会直接与内核交互，通过Libcontainer与内核交互；

3）Docker是对层级镜像的创新应用，即不同的容器可以共享底层的只读镜像，可以通过写入自己特有的内容后添加新的镜像层，新增的镜像层和下层的镜像一起又可以作为基础镜像被更上层的镜像使用。**【效率和空间占用有很大优势】**

## 1.2 功能和组价

- **Docker 客户端**

- **Docker daemon[Server]**

- **Docker 容器**

  在概念上，容器则很好地诠释了Docker集装箱的理念，集装箱可以存放任何杂物，可以通过邮轮将货物运输到世界各地，运输集装箱的邮轮和装载集装箱的码头都不用关心集装箱里的货物，这是一种标准的集装和运输方式。

- **Docker 镜像**

  与容器相对应，如果说容器提供了一个完整的、隔离的运行环境，那么镜像则是这个运行环境的静态体现，是一个还没有运行起来的“运行环境”。

  **Docker镜像通常是通过Dockerfile来创建的，Dockerfile提供了镜像内容的定制，同时也体现了层级关系的建立；另外，Docker镜像也可以通过Docker commit这样的命令来手动修改后的内容生成镜像。**

- **Registry**

  公有仓库：Docker Hub;支持企业级或者个人私有部署仓库。

  ## 1.3 功能和组价

## 1.4 概念澄清

### 1.4.1 Docker在LXC基础上做了什么

- LXC用户态工具【https://github.com/lxc/lxc】
- Linux Container

通常指第二种，即Docker在内核容器技术的基础上做了什么工作，简单地说，Docker在内核容器技术（Cgroup和Namespace）的基础上，提供了一个更高层的控制工具。

- 跨主机部署

  **程序的运行依赖于该机器的特定配置、包括网络、存储、发行版，而Docker将上述相关配置进行抽象并与应用程序一起打包，所以可以保证在不同硬件、不同配置的机器上Docker运行的程序与其所依赖的环境及配置是一致的**

- 以应用为中心

- 自动构建

- 版本管理

- 组件重用

- 共享

- 工具生态链

### 1.4.2 Docker容器和虚拟机之间有什么不同

**容器与虚拟机是互补的。虚拟机是用来进行硬件资源划分的完美解决方案，它利用硬件虚拟化技术，如VT-x、AMD-V或Privilege level (权限等级) 会同时通过一个Hypervisor层来实现资源的彻底隔离；而容器则是操作系统级别的虚拟化，利用的是内核的Cgroup和Namespace特性。此功能完全是通过软件来实现，仅仅是进程本身就可以与其他进程隔离开，不需要任何辅助**。



# 第二章 关于容器技术

## 2.1 容器技术的前世今生

容器技术，又称为虚拟化技术，硬件虚拟化、半虚拟化、操作系统虚拟化。

容器：最小化对外界的影响，不能在容器中把Host上的资源全部消耗掉，这就是资源控制。

一般来说，容器技术主要包括Namespace和Cgroup这两个内核特性。

**Namespace，**主要做**访问隔离**，针对一类资源尽心抽象，并将封装在一起提供给一个容器使用，对于这类资源，每个容器都有自己的抽象，而它们彼此之间是不可见的，所以就可以做到访问隔离。

**Cgroup，**Control Group的简称，**资源控制**，将一组进程放在一个控制组里，通过给这个控制组分配指定的可用资源，达到控制这一组进程可用资源的目的。

容器技术的历史：

- 1982，目录结构的简单抽象【chroot】

  不安全，用户可以逃离设定的根目录从而访问到Host上的文件

- 2000，pivot_root，解决chroot的安全性问题；Linux-VServer\SWsoft （现在的Odin）开发的Virtuozzo

- 2005，Odin开发了OpenVZ，最后在社区的合作下，形成了目前大家看到的Namespace和Cgroup，这时ring器技术开始逐渐进入大众的视野

  ## 2.2 一分钟理解容器

  容器 = Cgroup[资源控制]+Namespace[访问隔离]+rootfs[文件系统隔离]+容器引擎[生命周期控制]

  ​