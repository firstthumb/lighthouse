package net.javaci.lighthouse.server.ui;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * User: eerokoc
 * Date: 04/11/11
 * Time: 15:40
 */
public class MyVaadinApplication extends Application
{
    private Window window;

    @Override
    public void init()
    {
        window = new Window("My Vaadin Application");
        setMainWindow(window);
        Button button = new Button("Click Me");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                window.addComponent(new Label("Thank you for clicking"));
            }
        });
        window.addComponent(button);

    }

}
