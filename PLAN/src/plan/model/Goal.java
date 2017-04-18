package plan.model;

import java.util.ArrayList;

public class Goal {
String goalName;
ArrayList<Task> tasks;
public String getGoalName() {
	return goalName;
}
public ArrayList<Task> getTasks() {
	return tasks;
}
public void setGoalName(String goalName) {
	this.goalName = goalName;
}
public void setTasks(ArrayList<Task> tasks) {
	this.tasks = tasks;
}
	
}
