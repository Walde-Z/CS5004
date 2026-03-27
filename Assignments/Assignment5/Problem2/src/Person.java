public abstract class Person implements Creator{
  private String firstName;
  private String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    return ((Person) other).getFirstName().equals(getFirstName()) &&
        ((Person) other).getLastName().equals(getLastName());
  }
}
