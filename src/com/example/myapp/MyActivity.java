package com.example.myapp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.common.*;
import org.*;
import org.apache.sanselan.formats.jpeg.JpegImageMetadata;
import org.apache.sanselan.formats.tiff.TiffImageMetadata;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void btnClick(View view){


        final Map<String, Object> params = new HashMap<String, Object>();



        TextView tv = (TextView)findViewById(R.id.basicText);
        tv.setText("Welcome to android Nikos");

    }



    /**
     * Log all Exif data of the file.
     *
     * @param imageFile the image file.
     * @throws ImageReadException thrown if the metadata cannot be read.
     * @throws IOException        thrown in case of other errors while reading metadata.
     */
    public static void printAllExifData(final File imageFile) throws ImageReadException, IOException {


        final IImageMetadata metadata = Imaging.getMetadata(imageFile);

        TiffImageMetadata tiffImageMetadata;
        if (metadata instanceof JpegImageMetadata) {
            tiffImageMetadata = ((JpegImageMetadata) metadata).getExif();
        }
        else if (metadata instanceof TiffImageMetadata) {
            tiffImageMetadata = (TiffImageMetadata) metadata;
        }
        else {
            return;
        }

        @SuppressWarnings("unchecked")
        List<TiffImageMetadata.Item> items = (List<TiffImageMetadata.Item>) tiffImageMetadata.getItems();

        for (TiffImageMetadata.Item item : items) {
            //print
        }
    }

}
