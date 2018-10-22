# RangeSensor 

### Created by Group 6 of the Fall 2018 CS505 Design Patterns course

### Group 6 Members: Paul Borysewicz, David Hanley, Chris Mirabello, Wayne Work

## Overview 

The RangeSensor is a Java-based component library intended for use in Grove PI projects utilizing the Grove PI Distance Sensor https://www.dexterindustries.com/shop/distance-sensor/.

The library supports three different range-related features made available to client projects through the following classes:

- DetectRangeSensor (Use this class to obtain information about the distance of an object in front of the sensor)
- MovementRangeSensor (Use this class to detect movement)
- WithinRangeSensor (Use this class to get notified about the presence of an object within a specified range)

The component makes use of the Observer pattern, so client projects make use of the component by creating an instances of the above classes and then registering other components with these instances to receive updates. Please note, client components must implement the IRangeObserver interface.

## Required 3rd Party Libraries:

To use the RangeSensor component, download the following jars and include them in your project

* TODO

# Usage

```
class MyRangeAwareClass implements IRangeObserver {
  public void update(RangeSensor rangeSensor) {
    if (rangeSensor instanceof DetectRangeSensor) {
      // obtain range-related info from rangeSensor object
    } else if (rangeSensor instanceof MovementRangeSensor) {
      // movement detected!!
    } else if (rangeSensor instanceof WithinRangeSensor) {
      // object within range!!
    }
  }  
}
```






