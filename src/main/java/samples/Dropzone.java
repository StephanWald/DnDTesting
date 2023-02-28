package samples;

import org.dwcj.App;
import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.htmlcontainer.HtmlContainer;
import org.dwcj.controls.htmlcontainer.events.HtmlContainerJavascriptEvent;
import org.dwcj.controls.panels.AbstractDwcjPanel;



public class Dropzone extends AbstractControl {

    private final HtmlContainer hv;
    private AbstractDwcjPanel panel;

    /**
     * Create a new instance of the web component.
     */
    protected Dropzone() {
        super();

        hv = new HtmlContainer("");
        hv.setTabTraversable(false);
        hv.setFocusable(false);

        hv.setStyle("background","yellow");
        hv.setStyle("height","300px");
        hv.setStyle("width","300px");
        hv.setAttribute("ondrop","drop(event)");
        hv.setAttribute("ondragover","allowDrop(event)");

        hv.injectScript("""
                            function allowDrop(ev) {
                              ev.preventDefault();
                            }
                            function drop(ev) {
                              ev.preventDefault();
                              var data = ev.dataTransfer.getData(\"text\");
                              ev.target.appendChild(document.getElementById(data));
                              console.log('drop: '+data);
                              el = document.getElementById(data);
                              var x={};
                              x.id=data;
                              basisDispatchCustomEvent(el,x);
                            }
                """,true);

        hv.onJavascriptEvent(this::handleJavascriptEvents);
        App.consoleLog("constructor");
    }

    private void handleJavascriptEvents(HtmlContainerJavascriptEvent htmlContainerJavascriptEvent) {
        String ID = htmlContainerJavascriptEvent.getEventMap().get("id");
        String DropZoneID = hv.getId();
        App.msgbox("Control "+ID+" dropped in Dropzone "+DropZoneID,0,"event");
    }

    @Override
    protected void create(AbstractDwcjPanel p) {
        super.create(p);
        p.add(hv);

    }
}
