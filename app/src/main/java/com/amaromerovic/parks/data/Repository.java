package com.amaromerovic.parks.data;

import com.amaromerovic.parks.controller.AppController;
import com.amaromerovic.parks.model.Activity;
import com.amaromerovic.parks.model.Address;
import com.amaromerovic.parks.model.Contacts;
import com.amaromerovic.parks.model.EmailAddress;
import com.amaromerovic.parks.model.EntranceFee;
import com.amaromerovic.parks.model.EntrancePass;
import com.amaromerovic.parks.model.Exception;
import com.amaromerovic.parks.model.ExceptionHours;
import com.amaromerovic.parks.model.Image;
import com.amaromerovic.parks.model.OperatingHour;
import com.amaromerovic.parks.model.Park;
import com.amaromerovic.parks.model.PhoneNumber;
import com.amaromerovic.parks.model.StandardHours;
import com.amaromerovic.parks.model.Topic;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    static List<Park> parksList = new ArrayList<>();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void getPark(String PARKS_URL, final AsyncResponse callback) {
        executorService.execute(() -> {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, PARKS_URL, null
                    , response -> {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Park park = new Park();
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        if (jsonObject.has("id")) {
                            park.setId(jsonObject.getString("id"));
                        }
                        if (jsonObject.has("url")) {
                            park.setUrl(jsonObject.getString("url"));
                        }
                        if (jsonObject.has("fullName")) {
                            park.setFullName(jsonObject.getString("fullName"));
                        }
                        if (jsonObject.has("parkCode")) {
                            park.setParkCode(jsonObject.getString("parkCode"));
                        }
                        if (jsonObject.has("description")) {
                            park.setDescription(jsonObject.getString("description"));
                        }
                        if (jsonObject.has("latitude")) {
                            park.setLatitude(jsonObject.getString("latitude"));
                        }
                        if (jsonObject.has("longitude")) {
                            park.setLongitude(jsonObject.getString("longitude"));
                        }


                        if (jsonObject.has("activities")) {
                            ArrayList<Activity> activities = new ArrayList<>();
                            JSONArray jsonActivitiesArray = jsonObject.getJSONArray("activities");
                            for (int j = 0; j < jsonActivitiesArray.length(); j++) {
                                Activity activity = new Activity();
                                JSONObject jsonActivityObject = jsonActivitiesArray.getJSONObject(j);

                                if (jsonActivityObject.has("id")) {
                                    activity.setId(jsonActivityObject.getString("id"));
                                }
                                if (jsonActivityObject.has("name")) {
                                    activity.setName(jsonActivityObject.getString("name"));
                                }
                                activities.add(activity);
                            }
                            park.setActivities(activities);
                        }


                        if (jsonObject.has("topics")) {
                            ArrayList<Topic> topics = new ArrayList<>();
                            JSONArray jsonTopicsArray = jsonObject.getJSONArray("topics");
                            for (int j = 0; j < jsonTopicsArray.length(); j++) {
                                Topic topic = new Topic();
                                JSONObject jsonTopicObject = jsonTopicsArray.getJSONObject(j);
                                if (jsonTopicObject.has("id")) {
                                    topic.setId(jsonTopicObject.getString("id"));
                                }
                                if (jsonTopicObject.has("name")) {
                                    topic.setName(jsonTopicObject.getString("name"));
                                }
                                topics.add(topic);
                            }
                            park.setTopics(topics);
                        }


                        if (jsonObject.has("states")) {
                            park.setStates(jsonObject.getString("states"));
                        }


                        if (jsonObject.has("contacts")) {
                            Contacts contacts = new Contacts();
                            JSONObject jsonContactObject = jsonObject.getJSONObject("contacts");
                            if (jsonContactObject.has("phoneNumbers")) {
                                ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
                                JSONArray jsonPhoneNumberArray = jsonContactObject.getJSONArray("phoneNumbers");
                                for (int j = 0; j < jsonPhoneNumberArray.length(); j++) {
                                    PhoneNumber phoneNumber = new PhoneNumber();
                                    JSONObject phoneNumberObject = jsonPhoneNumberArray.getJSONObject(j);
                                    if (phoneNumberObject.has("phoneNumber")) {
                                        phoneNumber.setPhoneNumber(phoneNumberObject.getString("phoneNumber"));
                                    }
                                    if (phoneNumberObject.has("description")) {
                                        phoneNumber.setDescription(phoneNumberObject.getString("description"));
                                    }
                                    if (phoneNumberObject.has("extension")) {
                                        phoneNumber.setExtension(phoneNumberObject.getString("extension"));
                                    }
                                    if (phoneNumberObject.has("type")) {
                                        phoneNumber.setType(phoneNumberObject.getString("type"));
                                    }
                                    phoneNumbers.add(phoneNumber);
                                }
                                contacts.setPhoneNumbers(phoneNumbers);
                            }

                            if (jsonContactObject.has("emailAddresses")) {
                                JSONArray jsonEmailAddressArray = jsonContactObject.getJSONArray("emailAddresses");
                                ArrayList<EmailAddress> emailAddresses = new ArrayList<>();
                                for (int j = 0; j < jsonEmailAddressArray.length(); j++) {
                                    EmailAddress emailAddress = new EmailAddress();
                                    JSONObject jsonEmailAddressObject = jsonEmailAddressArray.getJSONObject(j);
                                    if (jsonEmailAddressObject.has("description")) {
                                        emailAddress.setDescription(jsonEmailAddressObject.getString("description"));
                                    }
                                    if (jsonEmailAddressObject.has("emailAddress")) {
                                        emailAddress.setEmailAddress(jsonEmailAddressObject.getString("emailAddress"));
                                    }
                                    emailAddresses.add(emailAddress);
                                }
                                contacts.setEmailAddresses(emailAddresses);
                            }
                            park.setContacts(contacts);
                        }


                        if (jsonObject.has("entranceFees")) {
                            ArrayList<EntranceFee> entranceFees = new ArrayList<>();
                            JSONArray jsonEntranceFeeArray = jsonObject.getJSONArray("entranceFees");
                            for (int j = 0; j < jsonEntranceFeeArray.length(); j++) {
                                EntranceFee entranceFee = new EntranceFee();
                                JSONObject jsonEntranceFeeObject = jsonEntranceFeeArray.getJSONObject(j);
                                if (jsonEntranceFeeObject.has("cost")) {
                                    entranceFee.setCost(jsonEntranceFeeObject.getString("cost"));
                                }
                                if (jsonEntranceFeeObject.has("description")) {
                                    entranceFee.setDescription(jsonEntranceFeeObject.getString("description"));
                                }
                                if (jsonEntranceFeeObject.has("title")) {
                                    entranceFee.setTitle(jsonEntranceFeeObject.getString("title"));
                                }
                                entranceFees.add(entranceFee);
                            }
                            park.setEntranceFees(entranceFees);
                        }


                        if (jsonObject.has("entrancePasses")) {
                            ArrayList<EntrancePass> entrancePasses = new ArrayList<>();
                            JSONArray jsonEntrancePassArray = jsonObject.getJSONArray("entrancePasses");
                            for (int j = 0; j < jsonEntrancePassArray.length(); j++) {
                                EntrancePass entrancePass = new EntrancePass();
                                JSONObject jsonEntrancePassObject = jsonEntrancePassArray.getJSONObject(j);
                                if (jsonEntrancePassObject.has("cost")) {
                                    entrancePass.setCost(jsonEntrancePassObject.getString("cost"));
                                }
                                if (jsonEntrancePassObject.has("description")) {
                                    entrancePass.setDescription(jsonEntrancePassObject.getString("description"));
                                }
                                if (jsonEntrancePassObject.has("title")) {
                                    entrancePass.setTitle(jsonEntrancePassObject.getString("title"));
                                }

                                entrancePasses.add(entrancePass);
                            }
                            park.setEntrancePasses(entrancePasses);
                        }

                        if (jsonObject.has("directionsInfo")) {
                            park.setDirectionsInfo(jsonObject.getString("directionsInfo"));
                        }
                        if (jsonObject.has("directionsUrl")) {
                            park.setDirectionsUrl(jsonObject.getString("directionsUrl"));
                        }

                        if (jsonObject.has("operatingHours")) {
                            ArrayList<OperatingHour> operatingHours = new ArrayList<>();
                            JSONArray jsonOperatingHoursArray = jsonObject.getJSONArray("operatingHours");
                            for (int j = 0; j < jsonOperatingHoursArray.length(); j++) {
                                OperatingHour operatingHour = new OperatingHour();
                                JSONObject jsonOperatingHourObject = jsonOperatingHoursArray.getJSONObject(j);

                                if (jsonOperatingHourObject.has("exceptions")) {
                                    ArrayList<Exception> exceptions = new ArrayList<>();
                                    JSONArray jsonExceptionsArray = jsonOperatingHourObject.getJSONArray("exceptions");
                                    for (int k = 0; k < jsonExceptionsArray.length(); k++) {
                                        Exception exception = new Exception();
                                        JSONObject jsonExceptionObject = jsonExceptionsArray.getJSONObject(k);

                                        ExceptionHours exceptionHours = new ExceptionHours();
                                        JSONObject jsonExceptionHoursObject = jsonExceptionObject.getJSONObject("exceptionHours");

                                        if (jsonExceptionHoursObject.has("wednesday")) {
                                            exceptionHours.setWednesday(jsonExceptionHoursObject.getString("wednesday"));
                                        }
                                        if (jsonExceptionHoursObject.has("monday")) {
                                            exceptionHours.setMonday(jsonExceptionHoursObject.getString("monday"));
                                        }
                                        if (jsonExceptionHoursObject.has("thursday")) {
                                            exceptionHours.setThursday(jsonExceptionHoursObject.getString("thursday"));
                                        }
                                        if (jsonExceptionHoursObject.has("sunday")) {
                                            exceptionHours.setSunday(jsonExceptionHoursObject.getString("sunday"));
                                        }
                                        if (jsonExceptionHoursObject.has("tuesday")) {
                                            exceptionHours.setTuesday(jsonExceptionHoursObject.getString("tuesday"));
                                        }
                                        if (jsonExceptionHoursObject.has("friday")) {
                                            exceptionHours.setFriday(jsonExceptionHoursObject.getString("friday"));
                                        }
                                        if (jsonExceptionHoursObject.has("saturday")) {
                                            exceptionHours.setSaturday(jsonExceptionHoursObject.getString("saturday"));
                                        }
                                        exception.setExceptionHours(exceptionHours);

                                        if (jsonExceptionObject.has("startDate")) {
                                            exception.setStartDate(jsonExceptionObject.getString("startDate"));
                                        }
                                        if (jsonExceptionObject.has("name")) {
                                            exception.setName(jsonExceptionObject.getString("name"));
                                        }
                                        if (jsonExceptionObject.has("endDate")) {
                                            exception.setEndDate(jsonExceptionObject.getString("endDate"));
                                        }
                                        exceptions.add(exception);
                                    }
                                    operatingHour.setExceptions(exceptions);
                                }

                                if (jsonOperatingHourObject.has("description")) {
                                    operatingHour.setDescription(jsonOperatingHourObject.getString("description"));
                                }

                                if (jsonOperatingHourObject.has("standardHours")) {
                                    JSONObject jsonStandardHoursObject = jsonOperatingHourObject.getJSONObject("standardHours");
                                    StandardHours standardHours = new StandardHours();
                                    if (jsonStandardHoursObject.has("wednesday")) {
                                        standardHours.setWednesday(jsonStandardHoursObject.getString("wednesday"));
                                    }
                                    if (jsonStandardHoursObject.has("monday")) {
                                        standardHours.setMonday(jsonStandardHoursObject.getString("monday"));
                                    }
                                    if (jsonStandardHoursObject.has("thursday")) {
                                        standardHours.setThursday(jsonStandardHoursObject.getString("thursday"));
                                    }
                                    if (jsonStandardHoursObject.has("sunday")) {
                                        standardHours.setSunday(jsonStandardHoursObject.getString("sunday"));
                                    }
                                    if (jsonStandardHoursObject.has("tuesday")) {
                                        standardHours.setTuesday(jsonStandardHoursObject.getString("tuesday"));
                                    }
                                    if (jsonStandardHoursObject.has("friday")) {
                                        standardHours.setFriday(jsonStandardHoursObject.getString("friday"));
                                    }
                                    if (jsonStandardHoursObject.has("saturday")) {
                                        standardHours.setSaturday(jsonStandardHoursObject.getString("saturday"));
                                    }

                                    operatingHour.setStandardHours(standardHours);
                                    if (jsonOperatingHourObject.has("name")) {
                                        operatingHour.setName(jsonOperatingHourObject.getString("name"));
                                    }

                                    operatingHours.add(operatingHour);
                                }
                            }
                            park.setOperatingHours(operatingHours);
                        }


                        if (jsonObject.has("addresses")) {
                            ArrayList<Address> addresses = new ArrayList<>();
                            JSONArray jsonAddressArray = jsonObject.getJSONArray("addresses");
                            for (int j = 0; j < jsonAddressArray.length(); j++) {
                                Address address = new Address();
                                JSONObject jsonAddressObject = jsonAddressArray.getJSONObject(j);
                                if (jsonAddressObject.has("postalCode")) {
                                    address.setPostalCode(jsonAddressObject.getString("postalCode"));
                                }
                                if (jsonAddressObject.has("city")) {
                                    address.setCity(jsonAddressObject.getString("city"));
                                }
                                if (jsonAddressObject.has("stateCode")) {
                                    address.setStateCode(jsonAddressObject.getString("stateCode"));
                                }
                                if (jsonAddressObject.has("line1")) {
                                    address.setLine1(jsonAddressObject.getString("line1"));
                                }
                                if (jsonAddressObject.has("type")) {
                                    address.setType(jsonAddressObject.getString("type"));
                                }
                                if (jsonAddressObject.has("line3")) {
                                    address.setLine3(jsonAddressObject.getString("line3"));
                                }
                                if (jsonAddressObject.has("line2")) {
                                    address.setLine2(jsonAddressObject.getString("line2"));
                                }

                                addresses.add(address);
                            }
                            park.setAddresses(addresses);
                        }


                        if (jsonObject.has("images")) {
                            ArrayList<Image> images = new ArrayList<>();
                            JSONArray jsonImageArray = jsonObject.getJSONArray("images");
                            for (int j = 0; j < jsonImageArray.length(); j++) {
                                Image image = new Image();
                                JSONObject jsonImageObject = jsonImageArray.getJSONObject(j);
                                if (jsonImageObject.has("credit")) {
                                    image.setCredit(jsonImageObject.getString("credit"));
                                }
                                if (jsonImageObject.has("title")) {
                                    image.setTitle(jsonImageObject.getString("title"));
                                }
                                if (jsonImageObject.has("altText")) {
                                    image.setAltText(jsonImageObject.getString("altText"));
                                }
                                if (jsonImageObject.has("caption")) {
                                    image.setCaption(jsonImageObject.getString("caption"));
                                }
                                if (jsonImageObject.has("url")) {
                                    image.setUrl(jsonImageObject.getString("url"));
                                }
                                images.add(image);
                            }
                            park.setImages(images);
                        }


                        if (jsonObject.has("weatherInfo")) {
                            park.setWeatherInfo(jsonObject.getString("weatherInfo"));
                        }
                        if (jsonObject.has("name")) {
                            park.setName(jsonObject.getString("name"));
                        }
                        if (jsonObject.has("designation")) {
                            park.setDesignation(jsonObject.getString("designation"));
                        }
                        parksList.add(park);
                    }
                    if (callback != null) {
                        callback.processPark(parksList);
                    }
                } catch (JSONException e) {
                    if (!PARKS_URL.isEmpty()) {
                        e.printStackTrace();
                    }
                }

            }, Throwable::printStackTrace);

            AppController.getInstance().addToRequestQueue(jsonObjectRequest);
            AppController.getInstance().getRequestQueue().start();
        });
    }

}
