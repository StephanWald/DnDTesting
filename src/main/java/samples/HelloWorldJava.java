package samples;

import org.dwcj.App;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

public class HelloWorldJava extends App {
    @Override
    public void run() throws DwcAppInitializeException {

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("gap", "20px");
        panel.setStyle("margin", "20px");
        panel.setStyle("padding", "20px");
        panel.setStyle("border", "1px dotted");

        panel.add(new Label("Hello World"));

        Button btn = new Button("Say Hello");
        panel.add(btn);

        btn.setTheme(Button.Theme.DANGER);
        btn.setExpanse(Button.Expanse.MEDIUM);

        btn.onClick(this::onButtonPush);
    }

    private void onButtonPush(ButtonClickEvent buttonClickEvent) {
        App.msgbox("Hello World!");
    }

}