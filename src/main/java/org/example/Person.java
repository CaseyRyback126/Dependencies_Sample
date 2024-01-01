package org.example;


import com.google.gson.Gson;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);
    private final String name;
    private final String lastName;
    private final int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("lastName", lastName)
                .append("age", age)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(lastName)
                .append(age)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person other)) {
            return false;
        }
        return new EqualsBuilder()
                .append(name, other.name)
                .append(lastName, other.lastName)
                .append(age, other.age)
                .isEquals();
    }

    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);

        LOGGER.info("Serialized JSON: {}", json);

        return json;
    }
}
