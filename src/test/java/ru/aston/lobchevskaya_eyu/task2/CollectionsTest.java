package ru.aston.lobchevskaya_eyu.task2;

import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class CollectionsTest {

    @Test
    public void arrayListConstructorsTest() {

        // Пустой конструктор с начальной емкостью внутреннего массива = 10
        ArrayList<String> list = new ArrayList<>();

        // Параметр конструктора - значение начального размера внутреннего массива
        ArrayList<String> list2 = new ArrayList<>(100);

        // Параметр конструктора - другая коллекция
        ArrayList<String> list3 = new ArrayList<>(list);

        // Основные методы ArrayList
        list.add("test1");
        list.add(0, "test2");
        list.addFirst("test3");
        list.addLast("test4");
        Assert.assertEquals(new String[] {"test3", "test2", "test1", "test4"}, list.toArray());

        list.sort(Comparator.reverseOrder());
        Assert.assertEquals(new String[] {"test4", "test3", "test2", "test1"}, list.toArray());

        list.set(1, "test1");
        Assert.assertEquals(new String[] {"test4", "test1", "test2", "test1"}, list.toArray());

        Assert.assertFalse(list.isEmpty());

        Assert.assertEquals(4, list.size());

        list.remove("test1");
        Assert.assertEquals(new String[] {"test4", "test2", "test1"}, list.toArray());

        list.clear();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void hashMapConstructorsTest() {

        // Создает хеш-отображение по умолчанию: объемом 16 и с коэффициентом загруженности 0.75
        HashMap<Integer, String> hashMap1 = new HashMap<>();

        // Создает хеш-отображение с заданной начальной емкостью
        // Для корректной и правильной работы HashMap размер внутреннего массива обязательно должен быть степенью двойки
        HashMap<Integer, String> hashMap2 = new HashMap<>(64);

        // Создает хеш-отображение с заданными начальной емкостью и коэффициентом загруженности
        HashMap<Integer, String> hashMap3 = new HashMap<>(256, 0.50f);

        // Создает хеш-отображение, инициализируемое элементами другого заданного отображения
        HashMap<Integer, String> hashMap4 = new HashMap<>(hashMap1);

        // Основные методы HashMap
        hashMap1.put(1, "test1");
        hashMap1.put(2, "test2");
        hashMap1.putIfAbsent(1, "test3");
        Assert.assertTrue(hashMap1.containsKey(1));
        Assert.assertTrue(hashMap1.containsValue("test1"));
        Assert.assertFalse(hashMap1.containsValue("test3"));

        Assert.assertEquals("test1", hashMap1.get(1));

        var set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        Assert.assertEquals(set, hashMap1.keySet());

        Collection<String> collection1 = new ArrayList<>();
        collection1.add("test1");
        collection1.add("test2");
        Assert.assertEquals(collection1.toArray(), hashMap1.values().toArray());

        hashMap1.remove(1);
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("test2");
        Assert.assertEquals(collection2.toArray(), hashMap1.values().toArray());

        hashMap1.clear();
        Assert.assertTrue(hashMap1.isEmpty());
    }

    @Test
    public void treeSetConstructorsTest() {

        // Создает пустое множество, которое будет сортироваться в порядке возрастания
        TreeSet<String> set1 = new TreeSet<>();

        // Создает множество, содержащее элементы другой коллекции
        TreeSet<String> set2 = new TreeSet<>(new LinkedList<>());

        // Создает пустое множество, которое будет сортироваться в соответствии с данным компаратором
        TreeSet<String> set3 = new TreeSet<>(Comparator.reverseOrder());

        // Создает TreeSet, который содержит элементы данного SortedSet
        TreeSet<String> set4 = new TreeSet<>(set1);

        // Основные методы TreeSet
        set1.add("test3");
        set1.add("test2");
        set1.add("test1");
        Assert.assertEquals(new String[] {"test1", "test2", "test3"}, set1.toArray());

        Collection<String> collection1 = new ArrayList<>();
        collection1.add("test5");
        collection1.add("test4");
        collection1.add("test4");
        set1.addAll(collection1);
        Assert.assertEquals(new String[] {"test1", "test2", "test3", "test4", "test5"}, set1.toArray());

        Assert.assertTrue(set1.contains("test4"));

        Assert.assertEquals("test1", set1.first());
        Assert.assertEquals("test5", set1.last());

        Assert.assertEquals(new String[] {"test1", "test2"}, set1.headSet("test3").toArray());
        Assert.assertEquals(new String[] {"test3", "test4", "test5"}, set1.tailSet("test3").toArray());

        set1.remove("test4");
        Assert.assertEquals(new String[] {"test1", "test2", "test3", "test5"}, set1.toArray());

        Assert.assertEquals(4, set1.size());

        Assert.assertEquals(new String[] {"test2"}, set1.subSet("test2", "test3").toArray());

        set1.clear();
        Assert.assertTrue(set1.isEmpty());
    }

    @Test
    public void collectionsTest() {

        Collection<String> collection = new ArrayList<>();

        collection.add("test1");
        collection.add("test3");
        collection.add("test2");
        Assert.assertEquals(new String[] {"test1", "test3", "test2"}, collection.toArray());

        Assert.assertTrue(collection.contains("test2"));

        collection.remove("test2");
        Assert.assertEquals(new String[] {"test1", "test3"}, collection.toArray());

        Assert.assertEquals(2, collection.size());

        collection.clear();
        Assert.assertTrue(collection.isEmpty());
    }
}