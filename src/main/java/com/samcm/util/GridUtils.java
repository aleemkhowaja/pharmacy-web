package com.samcm.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * GridUtils.java used to handles grid operations
 */
public class GridUtils
{

    /**
     * This method is used to build the Pagination object or Grd
     * @param pageNumber
     * @param pageSize
     * @param orderByProperty
     * @param orderByDir
     * @return
     */
    static public Pageable buildPageable(int pageNumber, int pageSize, String orderByProperty, String orderByDir)
    {
	Sort.Direction orderByDirection = null;
	if(orderByProperty != null && !orderByProperty.isEmpty())
	{
	    try
	    {
		orderByDirection = Sort.Direction.fromString(orderByDir);
	    }
	    catch(Exception e)
	    {
		orderByDirection = Sort.Direction.ASC;
	    }
	}
	Pageable pageable = PageRequest.of(pageNumber, pageSize,  JpaSort.unsafe(orderByDirection, orderByProperty));
	return pageable;
    }

    /*
     * static public <T, A> RestListMessage<A> convertPageToList(Page<T> page,
     * List<A> list) { RestListMessage<A> message = new RestListMessage<A>();
     * 
     * message.setContent(list); message.setCurrentPage(page.getNumber() + 1);
     * message.setTotalElements(page.getTotalElements());
     * message.setTotalPages(page.getTotalPages());
     * 
     * return message; } static public <T> RestListMessage<T>
     * convertPageToList(Page<T> page ) { RestListMessage<T> message = new
     * RestListMessage<T>();
     * 
     * message.setContent(page.getContent());
     * message.setCurrentPage(page.getNumber() + 1);
     * message.setTotalElements(page.getTotalElements());
     * message.setTotalPages(page.getTotalPages());
     * 
     * return message; } static public <T, A> RestListMessage<A>
     * convertPageToList(com.dasssmart.core.Page<T> page, List<A> list) {
     * 
     * RestListMessage<A> message = new RestListMessage<A>();
     * message.setContent(list); message.setCurrentPage(page.getPageNumber());
     * message.setTotalElements(page.getTotalElements());
     * message.setTotalPages(page.getPagesAvailable());
     * 
     * return message; }
     * 
     * static public <T> RestListMessage<T>
     * convertPageToList(com.dasssmart.core.Page<T> page) {
     * 
     * RestListMessage<T> message = new RestListMessage<T>();
     * message.setContent(page.getContent());
     * message.setCurrentPage(page.getPageNumber());
     * message.setTotalElements(page.getTotalElements());
     * message.setTotalPages(page.getPagesAvailable());
     * 
     * return message; }
     * 
     * 
     * public static String checksum(String message) { String digest = null; try
     * { MessageDigest md = MessageDigest.getInstance("MD5"); byte[] hash =
     * md.digest(message.getBytes("UTF-8")); // converting byte array to
     * Hexadecimal StringBuilder sb = new StringBuilder(2 * hash.length); for
     * (byte b : hash) { sb.append(String.format("%02x", b & 0xff)); } digest =
     * sb.toString(); } catch (NoSuchAlgorithmException |
     * UnsupportedEncodingException ex) { ex.printStackTrace(); } return digest;
     * }
     * 
     * public static float floor2Scale(float value, int scale) { float multipler
     * = (float) Math.pow(10, scale); return (float) (Math.floor(value *
     * multipler) / multipler); // return new BigDecimal(value).setScale(scale,
     * // RoundingMode.HALF_UP).floatValue(); }
     * 
     * public static double floor2Scale(double value, int scale) { double
     * multipler = Math.pow(10, scale); return Math.floor(value * multipler) /
     * multipler; } public static double double2Scale(double value, int scale) {
     * double multipler = Math.pow(10, scale); return Math.floor(value *
     * multipler) / multipler; } public static float round2Scale(float value,
     * int scale) { float multipler = (float) Math.pow(10, scale); return
     * Math.round(value * multipler) / multipler; // return new
     * BigDecimal(value).setScale(scale, // RoundingMode.HALF_UP).floatValue();
     * }
     * 
     * public static double round2Scale(double value, int scale) { double
     * multipler = Math.pow(10, scale); return Math.round(value * multipler) /
     * multipler; // return new BigDecimal(value).setScale(scale, //
     * RoundingMode.HALF_UP).doubleValue(); }
     * 
     * public static double floor2Scale(double value) { return
     * DassUtils.floor2Scale(value, 2); }
     * 
     * public static Date requestDateToGmt(Date serverDate, String format,
     * TimeZone requestTimeZone) { Date requestDate = dateToGmt(serverDate,
     * format, TimeZone.getDefault());
     * 
     * Date gmt = dateToGmt(requestDate, format, requestTimeZone);
     * 
     * return gmt; }
     * 
     * public static Date dateToGmt(Date origin, String format, TimeZone
     * originTimeZone) { return convertTimeZone(origin, format, originTimeZone,
     * TimeZone.getTimeZone("GMT")); }
     * 
     * public static Date gmtToDate(Date gmtDate, String format, TimeZone
     * toTimeZone) { return convertTimeZone(gmtDate, format,
     * TimeZone.getTimeZone("GMT"), toTimeZone); }
     * 
     * private static Date convertTimeZone(Date date, String format, TimeZone
     * fromTimeZone, TimeZone toTimeZone) { SimpleDateFormat toFormat = new
     * SimpleDateFormat(format); toFormat.setTimeZone(toTimeZone);
     * 
     * SimpleDateFormat gmtFormat = new SimpleDateFormat(format);
     * gmtFormat.setTimeZone(fromTimeZone);
     * 
     * try { String toFormatted = toFormat.format(date); return
     * gmtFormat.parse(toFormatted); } catch (Exception e) { return date; } }
     * 
     * public static Date[] getIntervalForCurrentDate(int type) { Calendar
     * calendar = Calendar.getInstance();
     * 
     * Date[] result = new Date[2];
     * 
     * // end date result[1] = calendar.getTime();
     * 
     * // start date calendar.add(type, -1); result[0] = calendar.getTime();
     * 
     * return result; }
     * 
     * 
     * public static String getRemoteAddress() { OAuth2AuthenticationDetails
     * details = (OAuth2AuthenticationDetails)
     * SecurityContextHolder.getContext().getAuthentication().getDetails();
     * return details.getRemoteAddress(); }
     * 
     * 
     * public static <T> T checkNotNull(T argument, String errorMessage) throws
     * ResourceNotFoundException { if (argument == null) { throw new
     * ResourceNotFoundException(errorMessage, null); } return argument; }
     * 
     * 
     * public static String longDuration2StrTime(long duration) {
     * 
     * String stringDur = "";
     * 
     * if (duration > 0) { long val = duration; int daysDuration = (int)
     * Math.floor(val / (24 * 60 * 60 * 1000)); if (daysDuration > 0) {
     * stringDur += daysDuration + "d, "; } val -= daysDuration * (24 * 60 * 60
     * * 1000); int hoursDuration = (int) Math.floor(val / (60 * 60 * 1000));
     * 
     * stringDur += twoDigitString(hoursDuration) + ":"; val -= hoursDuration *
     * (60 * 60 * 1000); int minutesDuration = (int) Math.floor(val / (60 *
     * 1000));
     * 
     * stringDur += twoDigitString(minutesDuration) + ":";
     * 
     * val -= minutesDuration * (60 * 1000); int secondsDuration = (int)
     * Math.floor(val / (1000));
     * 
     * stringDur += twoDigitString(secondsDuration);
     * 
     * 
     * } return stringDur; }
     * 
     * // public static String getStringHourMinuteSecondFormat(long value) { //
     * String stringValue = String.format("%02d:%02d:%02d",
     * TimeUnit.MILLISECONDS.toHours(value), //
     * TimeUnit.MILLISECONDS.toMinutes(value) -
     * TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(value)), //
     * TimeUnit.MILLISECONDS.toSeconds(value) -
     * TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(value))); //
     * return stringValue; // }
     * 
     * 
     * public static String millisToReadableStringTime(long miliseconds) {
     * 
     * long seconds = miliseconds / 1000; long hours = seconds / 3600; long day
     * = hours / 24; hours = hours % 24; long minutes = (seconds % 3600) / 60;
     * seconds = seconds % 60;
     * 
     * String dayString = day > 0 ? day + "d, " : "";
     * 
     * return dayString + twoDigitString(hours) + " : " +
     * twoDigitString(minutes) + " : " + twoDigitString(seconds); }
     * 
     * public static String twoDigitString(long number) {
     * 
     * if (number == 0) { return "00"; }
     * 
     * if (number / 10 == 0) { return "0" + number; }
     * 
     * return String.valueOf(number); }
     * 
     * public static double MICROSECOND_TO_MIN = (double) 1 / (60 * 1000);
     */
}