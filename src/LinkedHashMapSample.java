import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapSample {
    public static void main(String[] args) {
        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) { // 实现自定义删除策略，否则行为就和普遍 Map 没有区别
                return size() > 3;
            }
        };
        accessOrderedMap.put("Project1", "Valhalla");
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        // 模拟访问
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");
        System.out.println("Iterate over should be not affected:");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        // 触发删除
        accessOrderedMap.put("Project4", "Mission Control");
        System.out.println("Oldest entry should be removed:");
        accessOrderedMap.forEach((k, v) -> {// 遍历顺序不变
            System.out.println(k + ":" + v);
        });

        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>() {
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };


        Thread thread1 = new Thread(() -> {
            int integer = integerThreadLocal.get();
            System.out.println(integer);

            integerThreadLocal.set(3);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(integerThreadLocal.get());
        });
        thread1.start();


        Thread thread2 = new Thread(() -> {
            int integer = integerThreadLocal.get();
            System.out.println(integer);
            integerThreadLocal.set(5);
            System.out.println(integerThreadLocal.get());
        });
        thread2.start();
    }
}

