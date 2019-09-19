import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        HashMap<String, String[]> bigDictionary = new HashMap<>();

        dictionary.put("большой", new String[]{"колосальный", "огромный", "громадный", "гигантский"});
        dictionary.put("человек", new String[]{"персона", "личность", "индивидум"});
        dictionary.put("дом", new String[]{"жилище", "недвижимость", "квартира", "хата"});
        dictionary.put("красивый", new String[]{"прекрасный", "очаровательный", "симпатичный", "няшный", "привлекательный"});

        Set<String> keys = dictionary.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next().toString();
            String[] values = dictionary.get(key);
            bigDictionary.put(key, values);
            for (int i = 0; i < values.length ; i++) {
                String newKeys = values[i];
                ArrayList<String> stringArrayList = new ArrayList<>(values.length);
                stringArrayList.addAll(Arrays.asList(values));
                stringArrayList.remove(newKeys);
                stringArrayList.add(key);
                String[] newValues = new String[stringArrayList.size()];
                newValues = stringArrayList.toArray(newValues);
                System.out.println(newKeys + " - " +  Arrays.toString(newValues));
                bigDictionary.put(newKeys, newValues);
            }
        }

       System.out.println("Введите слово любое слово из словаря:");
        Scanner sc = new Scanner(System.in);
        String sentences = sc.nextLine();
        String[] words = sentences.split(" ");
        Random r = new Random();
        for (int i = 0; i < words.length ; i++) {
            String[] synonyms = (bigDictionary.get(words[i]));
            if (synonyms != null) {
                int randomNumber = r.nextInt(synonyms.length);
                System.out.printf(synonyms[randomNumber] + " ");
            } else {
                System.out.println("Не понял вас");
            }
        }


    }
}
