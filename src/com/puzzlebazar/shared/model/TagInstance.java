package com.puzzlebazar.shared.model;

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

import java.io.Serializable;


/**
 * A specific use of a {@link Tag} attached to a given object.
 * 
 * @author Philippe Beaudoin
 */
public interface TagInstance extends Serializable, HasKey {

  /**
   * Get the {@link Tag}.
   * 
   * @return The {@link Tag}.
   */
  public Tag getTag();

  /**
   * Get the total number of users who attached this tag to the object.
   * 
   * @return The number of users who attached this tag to the object.
   */
  public int getNumberOfTaggers();
  
  /**
   * @return The list of all users who attached this tag to the object.
   */
  public User getTaggers();
  
  public void tag( User user );
  public void untag( User user );
  
  
  
}
