package org.avaje.starter.domain

import groovy.transform.CompileStatic

import javax.persistence.Entity
import javax.persistence.Table

/**
 *
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
@Entity
@Table(name = "s_album")
@CompileStatic
class Album extends BaseModel {
	String name
	String description

	Date lastViewed

	Set<Photo> photos
}
