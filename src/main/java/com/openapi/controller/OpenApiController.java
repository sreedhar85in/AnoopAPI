package com.openapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.openapi.model.Timeresponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;





@RestController
@RequestMapping("/api")
public class OpenApiController {

	
	//@Operation(summary = "Returns a current date", description = "Returns A date",security = @SecurityRequirement(name = "basicAuth"), responses = {
			
	@Operation(summary = "Returns a current date", description = "Returns A date", responses = {
		
	      @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Timeresponse.class))) ,
	      @ApiResponse(description = "not found Operation", responseCode = "404")
	      })
	  @GetMapping("/time")  
	public ResponseEntity getCurrentSystemTime() {

		Timeresponse resp = new Timeresponse();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		resp.setDate(df.format(dateobj));

		return new ResponseEntity(resp, HttpStatus.OK);

	}
	
	
	
	@Operation(summary = "Returns a current date", description = "Returns A date",tags = "security.open", responses = {
			
		      @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Timeresponse.class))) ,
		      @ApiResponse(description = "not found Operation", responseCode = "404")
		      })
		  @GetMapping("/timeinYYYYformat")
	 @SecurityRequirements(value = {})
		public ResponseEntity getCurrentSystemTimeYYYYformat() {

			Timeresponse resp = new Timeresponse();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date dateobj = new Date();
			resp.setDate(df.format(dateobj));

			return new ResponseEntity(resp, HttpStatus.OK);

		}
	
	
	
	@Operation(summary = "Returns a current date", description = "Returns A date",tags = "security.open", responses = {
			
		      @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Timeresponse.class))) ,
		      @ApiResponse(description = "not found Operation", responseCode = "404")
		      })
		  @GetMapping("/timeinYYYformat")
	 @SecurityRequirements(value = {})
		public ResponseEntity getCurrentSystemTimeYYYformat() {

			Timeresponse resp = new Timeresponse();
			DateFormat df = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
			Date dateobj = new Date();
			resp.setDate(df.format(dateobj));

			return new ResponseEntity(resp, HttpStatus.OK);

		}
	
	
	@Operation(summary = "Returns a current date", description = "Returns A date", responses = {
			
		      @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Timeresponse.class))) ,
		      @ApiResponse(description = "not found Operation", responseCode = "404")
		      })
		  @GetMapping("/timeinYformat")	
		public ResponseEntity getCurrentSystemTimeYformat() {

			Timeresponse resp = new Timeresponse();
			DateFormat df = new SimpleDateFormat("dd/MM/y HH:mm:ss");
			Date dateobj = new Date();
			resp.setDate(df.format(dateobj));

			return new ResponseEntity(resp, HttpStatus.OK);

		}
	
	

}
