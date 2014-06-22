package org.avaje.starter.controllers

import com.avaje.ebean.EbeanServer
import com.avaje.ebean.FutureList
import com.avaje.ebean.FutureRowCount
import com.avaje.ebean.Query
import groovy.transform.CompileStatic
import org.avaje.starter.domain.Album
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.inject.Inject

/**
 *
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
@RestController
@CompileStatic
class AlbumController {
//	@Inject
	EbeanServer server

	@RequestMapping("/album/list")
	public MyAlbums list(
		@RequestParam(value="max", required=false, defaultValue="20") Integer requestedMax,
		@RequestParam(value="start", required=false, defaultValue="0") Integer requestedStart) {
		Query<Album> query = server.find(Album).order('lastViewed')

		FutureRowCount<Album> count = query.findFutureRowCount()
		FutureList<Album> list = query
			.setMaxRows(requestedMax.intValue())
			.setFirstRow(requestedStart)
			.findFutureList() // TODO: why deprecated?


		List<Album> listOfAlbums = list.get()
		return new MyAlbums(total: count.get(), albums: MyAlbum.translate(listOfAlbums))
	}

	public static class MyAlbum {
		long id
		String name
		String description
		Date lastViewed

		public static List<MyAlbum> translate(List<Album> albums) {
			return albums.collect({ Album album ->
				return new MyAlbum(id: album.id, name: album.name,
					description: album.description, lastViewed: album.lastViewed)
			})
		}
	}

	public static class MyAlbums {
		int total
		List<MyAlbum> albums = []


	}

}
