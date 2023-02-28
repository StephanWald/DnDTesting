package samples;

import org.dwcj.App;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.exceptions.DwcAppInitializeException;

public class DnDTest extends App {
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

        btn.setAttribute("draggable","true");
        btn.setAttribute("ondragstart","drag(event)");

        btn.onClick(this::onButtonPush);

        Button btn2 = new Button("Say Hello");
        panel.add(btn2);

        btn2.setAttribute("draggable","true");
        btn2.setAttribute("ondragstart","drag(event)");


        btn2.setTheme(Button.Theme.INFO);
        btn2.setExpanse(Button.Expanse.MEDIUM);



        addInlineJavaScript("""
                            function drag(ev) {
                              ev.dataTransfer.setData(\"text\", ev.target.id);
                            }
                            
                """,true);

        Dropzone drop1 = new Dropzone();
        panel.add(drop1);

        Dropzone drop2 = new Dropzone();
        panel.add(drop2);


    }

    private void onButtonPush(ButtonClickEvent buttonClickEvent) {
        App.msgbox("Hello World!");
    }

}
