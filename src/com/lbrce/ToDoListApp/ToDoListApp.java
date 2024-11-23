package com.lbrce.ToDoListApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ToDoListApp {
// List to hold tasks
private static ArrayList<String> tasks = new ArrayList<>();
public static void main(String[] args) {
// Create the main frame
JFrame frame = new JFrame("To-Do List");
frame.setSize(400, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new BorderLayout());
// Panel for input and buttons
JPanel inputPanel = new JPanel();
inputPanel.setLayout(new FlowLayout());
// Text field for task input
JTextField taskInput = new JTextField(20);
inputPanel.add(taskInput);
// Button to add a task
JButton addButton = new JButton("Add Task");
inputPanel.add(addButton);
// Button to remove the selected task
JButton removeButton = new JButton("Remove Selected Task");
inputPanel.add(removeButton);
// Text area to display tasks
JTextArea taskArea = new JTextArea();
taskArea.setEditable(false);
JScrollPane scrollPane = new JScrollPane(taskArea);
frame.add(scrollPane, BorderLayout.CENTER);
frame.add(inputPanel, BorderLayout.SOUTH);
// ActionListener for adding a task
addButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String task = taskInput.getText().trim();
if (!task.isEmpty()) {
tasks.add(task);
taskInput.setText(""); // Clear input field
updateTaskArea(taskArea);
} else {
JOptionPane.showMessageDialog(frame, "Task cannot be empty.");
}
}
});

// ActionListener for removing a selected task
removeButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String selectedTask = taskArea.getSelectedText();
if (selectedTask != null && !selectedTask.isEmpty()) {
tasks.remove(selectedTask);
updateTaskArea(taskArea);
} else {
JOptionPane.showMessageDialog(frame, "No task selected to remove.");
}
}
});
// Set frame visibility
frame.setVisible(true);
}
// Method to update the tasks displayed in the text area
private static void updateTaskArea(JTextArea taskArea) {
StringBuilder taskText = new StringBuilder();
for (String task : tasks) {
taskText.append(task).append("\n");
}
taskArea.setText(taskText.toString());
}
}
