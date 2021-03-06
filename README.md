if you have any problem ,you can mail to:longtask@gmail.com

依赖的项目：<a href="https://github.com/hoorace/common-dao"> common-dao </a>


务必修改compile_copy.bat和run.bat的$BASE_HOME的路径，执行compile_copy.bat把文件拷贝到bin下面。
WINDOWS下面拷贝选择请选择 F：目录

*********************************自动生成执行*********************************

到bin目录下面需要修改的地方：(每次更新svn后，必须运行compile_copy.bat一次)

1. run.bat中修改$BASE_HOME的路径地址

2. baseconfig.xml中 <br />
|--a：package中的路径，每个可以按照自己的需求定制，<br />
|   例如：您的domain的package位置是com.hqb360.trade.domain.entity，可以把base路径抽象为com.hqb360.trade，<br />
|   把domain的设置为domain.entity，dao服用base的路径。<br />
|--b: 修改数据库配置，制定需要生成的数据库表，用","号隔开。<br />
|--c：下面属于定制接口实现类的配置，一般不用修改。<br />

*********************************maven依赖置*********************************

1. 在maven的配置文件中增加apache的mirror：
   <pre><code> &lt;mirror&gt;
        &lt;id&gt;apache&lt;/id&gt;
        &lt;mirrorOf&gt;central&lt;/mirrorOf&gt;
        &lt;url&gt;http://repo1.maven.org/maven2&lt;/url&gt;
      &lt;/mirror&gt; 
   </code></pre>

2. 在应用的pom.xml文件中添加依赖
   <pre><code> &lt;dependency&gt;
        &lt;groupId&gt;org.yaml&lt;/groupId&gt;
        &lt;artifactId&gt;snakeyaml&lt;/artifactId&gt;
        &lt;version&gt;1.9&lt;/version&gt;
      &lt;/dependency&gt;
      &lt;dependency&gt;
        &lt;groupId&gt;org.testng&lt;/groupId&gt;
        &lt;artifactId&gt;testng&lt;/artifactId&gt;
        &lt;version&gt;6.1.1&lt;/version&gt;
        &lt;scope&gt;test&lt;/scope&gt;
      &lt;/dependency&gt;
   </code></pre>

*********************************代码相关说明*********************************

1. 分页，排序需要设置ListAdapter中的属性：<br />
    <pre><code>ListAdapter<PvsToday> adapter = new DefaultListAdapter<PvsToday>(); 
    adapter.adapter.setPageNo(1).setPageSize(20);//分页 
    adapter.setOrderItem("xx").setOrderType("ASC");//排序字段 </code></pre>
2. 为了解决DO和VO的导致JavaBean内容重复的问题，设计上考虑使用动态字段来传值，提高系统可拓展性。 <br />
    set动态字段： <br />
        adapter.setFiled("startTime", startTime).setFiled("endTime", endTime); <br />
    在xml配置中调用 <br />
        <pre><code>     &lt;isNotEmpty prepend="and" property = "dynamicFileds_startTime"&gt; 
            created_time &gt; #dynamicFileds_startTime# 
        &lt;/isNotEmpty&gt; 
        &lt;isNotEmpty prepend="and" property = "dynamicFileds_endTime"&gt; 
            created_time &lt; #dynamicFileds_endTime# 
        &lt;/isNotEmpty&gt; </code></pre>
3. update都是需要直接修改xml来完成，生成的内容仅供参考。 <br />


版本：<br />
********************** 1.0.1功能列表[2011-10-10]：**********************

1. 把domain中set方法返回对象修改为void,否则会导致标准JavaBean不能set参数；domain中属性方法修改为私有。[bugfix] <br />
2. compile_copy.bat增加了call命令，修复maven编译后自动退出的bug。[bugfix] <br />
3. 添加了jdbc.properties自动生成的功能 [new] <br />
4. 去掉了bin/{lib,template}目录下面的文件，让编译拷贝来完成。[new] <br />
5. 优化了测试代码。[new] <br />
6. 在数据库中如果是“id”结尾的int类型，在JavaBean中自动生成设置为long类型的。[new] <br />
7. 修复了“.”导致的无法读取dynamicFileds的数据的问题，暂时都修改为“_”[bugfix] <br />
