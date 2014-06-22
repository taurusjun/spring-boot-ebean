package org.avaje.starter.domain

import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.ManyToMany
import javax.persistence.Table

/**
 *
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
@Entity
@Table(name = "s_photo")
class Photo {
	String description

	@Lob
	byte[] image

	String imageType

	@ManyToMany
	Set<Album> albums
}
