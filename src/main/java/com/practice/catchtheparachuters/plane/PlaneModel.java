
package com.practice.catchtheparachuters.plane;

import com.practice.catchtheparachuters.Constants;
import com.practice.catchtheparachuters.Direction;
import com.practice.catchtheparachuters.BaseMovingComponentModel;

public class PlaneModel extends BaseMovingComponentModel implements Constants {

    public PlaneModel() {
        super(PLANE_IMAGE);
        direction = Direction.RIGHT;
    }
}
