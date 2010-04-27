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

package com.puzzlebazar.shared.puzzle.model;

import java.util.Date;

import javax.persistence.Id;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cached;
import com.puzzlebazar.shared.model.ActionRightsInfo;
import com.puzzlebazar.shared.model.User;
import com.puzzlebazar.shared.model.UserImpl;

/**
 * A persistent class that is able to save all the fields required
 * to support the {@link PuzzleInfo} interface.
 * 
 * @author Philippe Beaudoin
 */
@Cached
public class PuzzleInfoImpl implements PuzzleInfo<PuzzleInfoImpl> {

  private static final long serialVersionUID = -6880547981119961884L;
  
  private static final int deletedFlag  = 0x0001;
  private static final int rejectedFlag = 0x0002;
  private static final int publicFlag   = 0x0004;
  private static final int validFlag    = 0x0008;
  private static final int completeFlag = 0x0010;

  @Id private Long id;
  
  private long puzzleDetailsId;
  private Key<UserImpl> authorKey;
  private Key<PuzzleTypeImpl> puzzleTypeKey;
  
  private double difficulty;
  private double quality;
  private String sizeString;
  private String title;
  private int flags;
  private Date creationDate;
  private Date editionDate;
  private Date publicationDate;
  
  protected PuzzleInfoImpl() {   
  }
    
  /**
   * Copy constructor. Useful for downgrading a 
   * {@link com.puzzlebazar.server.puzzle.model.PuzzleInfoImplServer}
   * to a {@link PuzzleInfoImpl}, for sending to the client using 
   * serialization.
   * 
   * @param other The {@link PuzzleInfoImpl} to copy.
   */
  public PuzzleInfoImpl( PuzzleInfo<?> other ) {
    id = other.getId();
    puzzleDetailsId = other.getPuzzleDetailsKey().getId();
    authorKey = other.getAuthorKey();
    puzzleTypeKey = other.getPuzzleTypeKey();
    difficulty = other.getDifficulty();
    quality = other.getQuality();
    sizeString = other.getSizeString();
    title = other.getTitle();
    flags = 0;
    if( other.isDeleted() )
      flags |= deletedFlag;
    if( other.wasRejected() )
      flags |= rejectedFlag;
    if( other.isPublic() )
      flags |= publicFlag;
    if( other.isValid() )
      flags |= validFlag;
    if( other.isComplete() )
      flags |= completeFlag;
    creationDate = other.getCreationDate();
    editionDate = other.getEditionDate();
    publicationDate = other.getPublicationDate();
  }
  
  @Override
  public ActionRightsInfo canUserViewPuzzleDetails(User user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public double getDifficulty() {
    return difficulty;
  }

  @Override
  public Key<? extends PuzzleDetails<?>> getPuzzleDetailsKey() {
    // TODO Should combine the puzzleDetailsId with the puzzleType to generate the key
    //      Could lazily store it.
    return null;
  }

  @Override
  public double getQuality() {
    return quality;
  }

  @Override
  public String getSizeString() {
    return sizeString;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public boolean isComplete() {
    return (flags & completeFlag) != 0;
  }

  @Override
  public boolean isValid() {
    return (flags & validFlag) != 0;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public Key<UserImpl> getAuthorKey() {
    return authorKey;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

  @Override
  public Date getEditionDate() {
    return editionDate;
  }

  @Override
  public Date getPublicationDate() {
    return publicationDate;
  }

  @Override
  public boolean isDeleted() {
    return (flags & deletedFlag) != 0;
  }

  @Override
  public boolean isPublic() {
    return (flags & publicFlag) != 0;
  }

  @Override
  public boolean wasRejected() {
    return (flags & rejectedFlag) != 0;
  }

  @Override
  public Key<PuzzleTypeImpl> getPuzzleTypeKey() {
    return puzzleTypeKey;
  }

  @Override
  public Key<PuzzleInfoImpl> createKey() {
    return new Key<PuzzleInfoImpl>(PuzzleInfoImpl.class, id);
  }

}