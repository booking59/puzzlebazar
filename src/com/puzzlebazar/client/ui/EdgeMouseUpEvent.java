/**
 * Copyright 2010 Philippe Beaudoin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.puzzlebazar.client.ui;

import com.puzzlebazar.shared.util.Vec2i;

/**
 * Represents a mouse up event within an edge of a square grid.
 * See {@link SquareGridManipulatorImpl} for details.
 */
public class EdgeMouseUpEvent extends EdgeEvent<EdgeMouseUpHandler> {

  /**
   * Event type for edge mouse up events. Represents the meta-data associated with
   * this event.
   */
  private static final Type<EdgeMouseUpHandler> TYPE = new Type<EdgeMouseUpHandler>();

  /**
   * Gets the event type associated with edge mouse up events.
   * 
   * @return the handler type
   */
  public static Type<EdgeMouseUpHandler> getType() {
    return TYPE;
  }
  /**
   * Creates a {@link EdgeMouseUpEvent} at the specified cell coordinate.
   * See {@link com.puzzlebazar.shared.util.Recti} for the difference between cell and vertex coordinates.
   * 
   * @param vertical {@code true} if the edge is vertical, {@code false} if it is horizontal.
   * @param edge The edge coordinates. 
   *     For vertical edges, x must be a vertex coordinate and y must be a cell coordinate.
   *     For horizontal edges, x must be a cell coordinate and y must be a vertex coordinate.
   */
  public EdgeMouseUpEvent(boolean vertical, Vec2i edge) {
    super(vertical, edge);
  }

  @Override
  public final Type<EdgeMouseUpHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(EdgeMouseUpHandler handler) {
    handler.onEdgeMouseUp(this);
  }

}
