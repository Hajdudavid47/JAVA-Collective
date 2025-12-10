package pgdp.sim.ui;

import pgdp.sim.SimConfig;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Arrays;

public class Settings {

    public Settings() {
    }

    public JScrollPane getSettings() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setAlignmentY(Component.TOP_ALIGNMENT);

        Arrays.stream(SimConfig.class.getDeclaredFields())
                .filter(field -> Modifier.isStatic(field.getModifiers()) && field.getType() == int.class)
                .map(Setting::new)
                .forEach(panel::add);

        var scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(260, 0));
        return scrollPane;
    }

    private class Setting extends JPanel {
        private static final long serialVersionUID = 3968052765925950441L;

        Setting(Field setting) {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createTitledBorder(setting.getName()));
            var field = new JFormattedTextField(NumberFormat.getIntegerInstance());
            add(field, BorderLayout.CENTER);
            try {
                field.setValue(setting.get(null));
            } catch (IllegalArgumentException | IllegalAccessException e1) {
                throw new RuntimeException(e1);
            }
            field.addPropertyChangeListener("value", event -> {
                try {
                    setting.setInt(null, (Integer) event.getNewValue());
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
