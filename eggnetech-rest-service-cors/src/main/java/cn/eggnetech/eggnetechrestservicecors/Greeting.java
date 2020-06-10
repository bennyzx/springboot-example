package cn.eggnetech.eggnetechrestservicecors;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/16
 */
public class Greeting {
    private final long id;
    private final String content;

    public Greeting() {
        this.id = -1L;
        this.content = "";
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
