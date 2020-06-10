package cn.eggnetech.eggnetechgreeting.restservice;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/14
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    /**
     * @name:
     * @description: Created by Benny Zhou on 2020/3/15
     */
    public static class RestServiceApplication {
    }
}
