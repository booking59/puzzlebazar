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

package com.puzzlebazar.shared.puzzle.heyawake.model;

import com.googlecode.objectify.Key;
import com.puzzlebazar.shared.puzzle.model.PuzzleDetailsImpl;
import com.puzzlebazar.shared.util.Has2DSize;

/**
 * @author Philippe Beaudoin
 */
public class HeyawakePuzzleDetails extends PuzzleDetailsImpl<HeyawakePuzzleDetails>
implements Has2DSize {

  private static final long serialVersionUID = -598438240782558135L;

  private int width;
  private int height;

  protected HeyawakePuzzleDetails() {
  }
  
  public HeyawakePuzzleDetails(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public Key<HeyawakePuzzleDetails> createKey() {
    return new Key<HeyawakePuzzleDetails>(puzzleInfoKey, HeyawakePuzzleDetails.class, getId());
  }

}
