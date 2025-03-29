#This is a demo spring webflow application with jsf to demonstrate a spring-faces 3.0.1 Version Bug in combination with myfaces 4.1.1

# error to reproduce

java.lang.ClassCastException: class jakarta.faces.component.html.HtmlCommandButton cannot be cast to class jakarta.faces.component.ActionSource2 (jakarta.faces.component.html.HtmlCommandButton and jakarta.faces.component.ActionSource2 are in unnamed module of loader 'app')
	at org.springframework.faces.webflow.FlowActionListener.processAction(FlowActionListener.java:74) ~[spring-faces-3.0.1.jar:3.0.1]
	at org.springframework.faces.model.SelectionTrackingActionListener.processAction(SelectionTrackingActionListener.java:64) ~[spring-faces-3.0.1.jar:3.0.1]
	at jakarta.faces.component.UICommand.broadcast(UICommand.java:65) ~[myfaces-api-4.1.1.jar:4.1.1]
	at jakarta.faces.component.UIViewRoot._broadcastAll(UIViewRoot.java:1248) ~[myfaces-api-4.1.1.jar:4.1.1]
	at jakarta.faces.component.UIViewRoot.broadcastEvents(UIViewRoot.java:429) ~[myfaces-api-4.1.1.jar:4.1.1]

# how to reproduce the error

1. run the Starter.java class
2. call http://localhost:8080/hello-flow
3. click on the button "say hello"

the ClassCastException error is thrown from spring-faces
