package com.bluegarden.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bluegarden.entities.Picture;
import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

@Controller
@RequestMapping("test")
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		BlobstoreService blobStoreService = BlobstoreServiceFactory
				.getBlobstoreService();
		String url = blobStoreService.createUploadUrl("/uploadImage");
		modelMap.addAttribute("uploadUrl", url);

		return "testUpload";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@RequestParam MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			System.out.println("File : " + file.getBytes().length
					+ "\nFile Name: " + file.getOriginalFilename());
		}

		return "redirect:http://www.google.com";
	}

	@RequestMapping(value = "uploadImage", method = RequestMethod.POST)
	public String uploadImage(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		BlobstoreService blobStoreService = BlobstoreServiceFactory
				.getBlobstoreService();

		// save the upload file
		blobStoreService.getUploads(req);
		//note/todo: it should be redirected with HttpServletResponse instead redirect for this case.
		return "redirect:/test/list";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listImages(ModelMap model) {
		BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
		Iterator<BlobInfo> list = blobInfoFactory.queryBlobInfos();
		List<Picture> pictures = new ArrayList<>();
		ImagesService imageService = ImagesServiceFactory.getImagesService();

		// iterate over the blobs
		while (list.hasNext()) {
			BlobInfo blobInfo = list.next();
			String url = imageService.getServingUrl(ServingUrlOptions.Builder
					.withBlobKey(blobInfo.getBlobKey()));

			// add picture object
			// adding =s0 returns the original size of the image.
			// https://developers.google.com/appengine/docs/python/images/functions
			// god the doc of app engine for java is a sh1t....
			pictures.add(new Picture(blobInfo.getFilename(), url + "=s0",
					blobInfo.getCreation(), blobInfo.getSize()));

		}
		model.addAttribute("pictures", pictures);

		return "listImages";
	}
}
