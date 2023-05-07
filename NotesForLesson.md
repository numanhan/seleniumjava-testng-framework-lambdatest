PomManager dan Annotation lar ayrıldı. Annotations adında yeni bir class oluşturuldu.
PomManager class ı da bu Annotations class ından miras aldı.

> @BeforeMethod(value="@special") ya da @AfterMethod("@phone)

şeklindeki tanımlamalarla Cucumber scenario larında JUnit ile BeforeMethod ya da AfterMethod gibi metotları, scenario lara özel hale getirebiliyorsun. 
Konumuz TestNG ise @Test lere özel hale getirebilir miyiz?

> Junit deki "order=0" ın yerine TestNG de "priority=3" gibi bir kullanım var. Ama Junit deki "value='@iphone'" un yerine TestNG de ne var ki?

```java
@BeforeMethod(onlyForGroups = "group1")
    public void beforeMethod1() {
        System.out.println("beforeMethod1 is executed");
    }

    @BeforeMethod(onlyForGroups = "group2")
    public void beforeMethod2() {
        System.out.println("beforeMethod2 is executed");
    }

    @Test(groups = "group1")
    public void test1() {
        System.out.println("test1 is executed");
    }
```

Bu şekilde testlere özel @BeforeMethod yapmak mümkün TestNG frameworklerde. 
> Ama ileride Cucumber-TestNG şeklinde bir yapı oluşturduğumda bunun oradaki karşılığı bu mu olur ondan emin değilim.

