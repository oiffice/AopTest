# Aop
在撰寫 restful api 的時候，常常會需要紀錄 request 的參數, request time 或是 user name；亦或者是會對參數做驗證等，這些都是在真正的商業邏輯之前會去做到的事情。以 log 為例，當然可以在每個 controller 的 method 裡面都去紀錄，但這樣的作法常常會需要撰寫一些與真正商業邏輯無關的方法，也有可能漏寫了 log。
只要定義好 AOP，我們就不需要自己去關注 log 該寫些什麼或是是否漏寫了 log。

## Spring-AOP

* Aspect - 指定某類別為一個 aop 類別，裡面可以定義針對哪些函示作 log 或是驗證等事項
* Joinpoint - 當程式執行到某的點，可能是函式被執行的時候或是例外被拋出的時候。在 spring 都為函式被執行的時候。
* Advice - 定義在特定的 join point 發生的哪個時間點執行實作。其中包含有，`before`, `after`, `afterThrowing`, `afterReturning` and `around`。每個的定義如：[Spring Aop Type of advice section](https://docs.spring.io/spring/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html)
* Pointcut - 更明確的定義出在 joinpoint 發生的哪個時間點執行，可能函式內某個方法被執行，或是參數被修改。ex:`@Pointcut("execution(public String org.baeldung.dao.FooDao.findById(Long))")`

## Note
* execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
    * modifier-pattern：表示方法的修飾符
    * ret-type-pattern：表示方法的返回值
    * declaring-type-pattern?：表示方法所在的路徑
    * name-pattern：表示方法名
    * param-pattern：表示方法的参數
    * throws-pattern：表示方法抛出的異常