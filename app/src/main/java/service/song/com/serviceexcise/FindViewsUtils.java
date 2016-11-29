package service.song.com.serviceexcise;

import android.view.View;

import java.lang.reflect.Field;

public class FindViewsUtils {
    public static void findAllViews(Object object, View rootView) {

        Class classTemp = object.getClass();
        Field[] fields = classTemp.getDeclaredFields();
        for (Field field : fields) {
            Id id = field.getAnnotation(Id.class);
            if (id != null) {
                int value = id.value();
                if (value != -1) {

                    try {
                        Object view = rootView.findViewById(value);
                        field.setAccessible(true);
                        field.set(object, view);
                    } catch (IllegalAccessException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
}
