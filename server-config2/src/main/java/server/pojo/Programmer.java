package server.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "programmer")
@RefreshScope //定义下面配置热刷新范围
public class Programmer {

    private String name;
    private int age;
    private boolean married;
    private Date hireDate;
    private float salary;
    private int random;
    private Map<String,String> skill;
    private List<String> company;


    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", married=" + married +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", random=" + random +
                ", skill=" + skill +
                ", company=" + company +
                '}';
    }

    public Programmer() {
    }

    public Programmer(String name, int age, boolean married, Date hireDate, float salary, int random, Map<String, String> skill, List<String> company) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.hireDate = hireDate;
        this.salary = salary;
        this.random = random;
        this.skill = skill;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public Map<String, String> getSkill() {
        return skill;
    }

    public void setSkill(Map<String, String> skill) {
        this.skill = skill;
    }

    public List<String> getCompany() {
        return company;
    }

    public void setCompany(List<String> company) {
        this.company = company;
    }
}
