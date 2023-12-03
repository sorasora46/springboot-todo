package com.sora.todo.pojos.responses;

public class CreateTodoData implements ResponseData {
    private Integer id;

    public CreateTodoData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
