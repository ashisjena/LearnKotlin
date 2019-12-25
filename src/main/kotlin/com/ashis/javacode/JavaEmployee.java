package com.ashis.javacode;

public class JavaEmployee {
  private final String firstName;
  private final boolean fullTime;

  public JavaEmployee(String firstName) {
    this(firstName, true);
  }

  public JavaEmployee(String firstName, boolean fullTime) {
    this.firstName = firstName;
    this.fullTime = fullTime;
  }

  public String getFirstName() {
    return firstName;
  }

  public boolean isFullTime() {
    return fullTime;
  }

  @Override
  public String toString() {
    return "JavaEmployee{" +
        "firstName='" + getFirstName() + '\'' +
        ", fullTime=" + isFullTime() +
        '}';
  }
}
