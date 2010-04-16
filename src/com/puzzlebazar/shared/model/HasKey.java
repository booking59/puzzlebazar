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

package com.puzzlebazar.shared.model;

/**
 * This interface is used on objects that should be storable in
 * the datastore.
 * 
 * @author Philippe Beaudoin
 */
public interface HasKey {

  /**
   * @return This object's key, encoded as a string.
   */
  public String getKey();
  
  /**
   * @return This object's numerical id, obtained from its key.
   */
  public long getId();
}
