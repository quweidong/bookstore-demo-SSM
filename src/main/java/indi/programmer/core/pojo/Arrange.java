package indi.programmer.core.pojo;

/**指定排序字段和排序方法的类*/
public class Arrange {
    private String arrangeField;
    private String arrangeMethod;

    public Arrange() {
    }

    public Arrange(String arrangeField, String arrangeMethod) {
        this.arrangeField = arrangeField;
        this.arrangeMethod = arrangeMethod;
    }

    public String getArrangeField() {
        return arrangeField;
    }

    public void setArrangeField(String arrangeField) {
        this.arrangeField = arrangeField;
    }

    public String getArrangeMethod() {
        return arrangeMethod;
    }

    public void setArrangeMethod(String arrangeMethod) {
        this.arrangeMethod = arrangeMethod;
    }
}
