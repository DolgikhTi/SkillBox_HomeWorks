import java.util.Arrays;

public class Hospital {

    public final static float MIN_HEALTH_TEMP = 36.2f;
    public final static float MAX_HEALTH_TEMP = 36.9f;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов

        float[] patientTemperature = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++){
            patientTemperature[i] = (float) (((Math.random() * 8) + 32) * 100) / (float) 100.0;
        }

        return patientTemperature;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        int count = 0;
        float sum = 0.0f;
        for (float temperatureData1 : temperatureData) {
            if (temperatureData1 >= MIN_HEALTH_TEMP && temperatureData1 <= MAX_HEALTH_TEMP) {
                count++;
            }
            sum += temperatureData1;
        }
        float average = sum / temperatureData.length;
        return String.format(
                "Температуры пациентов: %s\nСредняя температура: %.2f\nКоличество здоровых: %d",
                Arrays.toString(temperatureData).
                        replaceAll("^\\[|\\]$", "").replaceAll(",", ""), average, count);

    }
}
