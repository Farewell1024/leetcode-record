package com.zhangyu.leetcoderecord.problems;

import java.util.*;

/**
 * Function: 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * @author zhangyu
 * Date: 2020/10/31
 * @since JDK 1.8
 */
public class Solution0381 {

    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();

        // 向集合中插入 1 。返回 true 表示集合不包含 1 。
        System.out.println(collection.insert(1));

        // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        System.out.println(collection.insert(1));

        // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        System.out.println(collection.insert(2));

        // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        System.out.println(collection.getRandom());

        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        System.out.println(collection.remove(1));

        // getRandom 应有相同概率返回 1 和 2 。
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());

    }

    private static class RandomizedCollection {

        // 存储元素
        private List<Integer> list = new ArrayList<>();

        private Map<Integer, Set<Integer>> map = new HashMap<>();

        private static Random random = new Random();
        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {

        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            list.add(val);
            boolean b = map.containsKey(val);
            Set<Integer> set = b ? map.get(val) : new HashSet<Integer>();
            set.add(list.size() - 1);

            map.put(val, set);
            return !b;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Iterator<Integer> iterator = map.get(val).iterator();
            int i = iterator.next();
            int last = list.size() - 1;
            int tmp = list.get(last);
            list.set(i, tmp);
            list.remove(last);
            map.get(val).remove(i);
            map.get(tmp).remove(last);
            if (i < last){
                map.get(tmp).add(i);
            }
            if (map.get(val).size() == 0) {
                map.remove(val);
            }
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));
        }
    }

}
