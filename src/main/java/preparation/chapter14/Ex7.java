package preparation.chapter14;

import java.util.*;
import java.util.stream.Collectors;

public class Ex7 {
    public static class Student{
        public String name;
        public int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("<%s, %d>", name, age);
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Greg",14)
                , new Student("John",12)
                , new Student("Andy",11)
                , new Student("Jim",13)
                , new Student("Phil",12)
                , new Student("Bob",13)
                , new Student("Chip",13)
                , new Student("Tim",14)
        );
        partitionStudentsByAge(students);
        groupStudentByAge(students);
    }

    public static class AgePartition {
        public int offset;
        public int age;
        public int size;

        public AgePartition(int offset, int age, int size) {
            this.offset = offset;
            this.age = age;
            this.size = size;
        }

        @Override
        public String toString() {
            return "AgePartition{" +
                    "offset=" + offset +
                    ", age=" + age +
                    ", size=" + size +
                    '}';
        }
    }

    public static void partitionStudentsByAge(List<Student> students){
        Map<Integer, Integer> ageFreq = students.stream()
                .collect(Collectors.groupingBy(student -> student.age, Collectors.summingInt(x -> 1)));
        int nextOffset = 0;
        Map<Integer, Integer> ageToIdx = new HashMap<>();
        List<AgePartition> aps = new ArrayList<>(ageFreq.size());
        int i = 0;
        for(Map.Entry<Integer, Integer> f : ageFreq.entrySet()){
            aps.add(new AgePartition(nextOffset, f.getKey(), nextOffset + f.getValue()));
            nextOffset += f.getValue();
            ageToIdx.put(f.getKey(), i++);
        }
        i = 0;
        System.out.println(students);
        while(i < students.size()){
            for(AgePartition ap : aps){
                if(ap.offset < ap.size) {
                    int currentAge = students.get(ap.offset).age;
                    if (currentAge == ap.age) {
                        ap.offset++;
                    } else {
                        int correctIdx = ageToIdx.get(currentAge);
                        AgePartition correctPartition = aps.get(correctIdx);
                        Collections.swap(students, correctPartition.offset++, ap.offset);
                    }
                    i++;
                }
            }
        }
        System.out.println(students);
    }

    public static void groupStudentByAge(List<Student> students){
        Map<Integer, Integer> ageToCount = students.stream()
                .collect(Collectors.groupingBy(student -> student.age, Collectors.summingInt(x -> 1)));
        Map<Integer, Integer> ageToOffset = new HashMap<>();
        int nextOffset = 0;
        for(Map.Entry<Integer, Integer> entry : ageToCount.entrySet()){
            ageToOffset.put(entry.getKey(), nextOffset);
            nextOffset += entry.getValue();
        }
        while(!ageToCount.isEmpty()){
            Map.Entry<Integer, Integer> from = ageToCount.entrySet().iterator().next();
            Integer correctIdx = ageToOffset.get(from.getKey());
                Integer currentStudentAge = students.get(correctIdx).age;
            Integer currentIdx = ageToOffset.get(currentStudentAge);
            Collections.swap(students, correctIdx, currentIdx);
            ageToOffset.put(currentStudentAge, currentIdx + 1);
            ageToCount.put(currentStudentAge, ageToCount.get(currentStudentAge) - 1);
            if(ageToCount.get(currentStudentAge) == 0){
                ageToCount.remove(currentStudentAge);
            }
        }
        System.out.println(students);
    }
}
