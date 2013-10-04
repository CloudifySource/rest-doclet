package org.cloudifysource.restDoclet.exampleGenerators;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author edward
 */
public class ObjectCreatorTest {

  private ObjectCreator objectCreator_;

  @Before
  public void setup() {
    objectCreator_ = new ObjectCreator();
  }

  @Test
  public void createsAnObject() throws IllegalAccessException {
    assertThat(objectCreator_.createObject(Fish.class), instanceOf(Fish.class));
  }

  @Test
  public void setsAStringFieldOnAnObject() throws IllegalAccessException {
    Fish fish = (Fish) objectCreator_.createObject(Fish.class);
    assertThat(fish.getName(), notNullValue());
    assertThat(fish.getName().length(), greaterThan(0));
  }

  @Test
  public void createsNestedClasses() throws IllegalAccessException {
    FishBowl fishBowl = (FishBowl) objectCreator_.createObject(FishBowl.class);
    assertThat(fishBowl.getFish(), instanceOf(Fish.class));
    assertThat(fishBowl.getFish().getName(), notNullValue());
  }

  @Test
  public void createsLists() throws IllegalAccessException {
    Aquarium aquarium = (Aquarium) objectCreator_.createObject(Aquarium.class);
    assertThat(aquarium.getFishes(), instanceOf(List.class));
    assertThat(aquarium.getFishes(), hasSize(greaterThan(0)));
    assertThat(aquarium.getFishes().get(0), instanceOf(Fish.class));
    assertThat(aquarium.getFishes().get(0).getName(), notNullValue());
  }

  static class Fish {
    private String name_;

    public String getName() {
      return name_;
    }
  }

  static class FishBowl {
    private Fish fish_;

    public Fish getFish() {
      return fish_;
    }
  }

  static class Aquarium {
    private List<Fish> fishes_;

    public List<Fish> getFishes() {
      return fishes_;
    }
  }
}
