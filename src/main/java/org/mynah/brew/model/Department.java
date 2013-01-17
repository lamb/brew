package org.mynah.brew.model;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Department {

    private Integer id;
    private Integer superior;
    @NotNull(message = "姓名不能为空！")
    @Size(max = 100, message = "部门名称最大长度为100")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuperior() {
        return superior;
    }

    public void setSuperior(Integer superior) {
        this.superior = superior;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
