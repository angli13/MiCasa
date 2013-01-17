package com.example.micasa;





import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainTabla extends Activity {

	 GridView MyGrid;
	 public String p;
	   @Override
	   public void onCreate(Bundle savedInstanceState){
	      super.onCreate(savedInstanceState);
	      requestWindowFeature(Window.FEATURE_NO_TITLE);
	      //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	      //setContentView(R.layout.title);
	      //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
	      //TextView customTitleText = (TextView) findViewById(R.id.customtitlebar);
	      setContentView(R.layout.activity_main_tabla);
	      /*Here we setContentView() to main.xml, get the GridView and then fill it with the
	                   ImageAdapter class that extend from BaseAdapter */

	      MyGrid = (GridView)findViewById(R.id.MyGrid);
	      MyGrid.setAdapter(new ImageAdapter(this));
		  MyGrid.setOnItemClickListener(new OnItemClickListener() {
		        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		        	switch (position){
		    		case 1:AbrirExplorador("arquitectos");
		    		break;
		    		case 9:AbrirExplorador("marmol");
		    		break;
		    		case 10:AbrirExplorador("disenadoresIndustriales");
		    		break;
		    		case 18: AbrirExplorador("puertasventanas");
		    		break;
		    		default :Aviso();
		    		break;
		    		}
		        }
		    });
	   }
	   
	   
	   public class ImageAdapter extends BaseAdapter
	   {
	      Context MyContext;
	      
	      public ImageAdapter(Context _MyContext)
	      {
	         MyContext = _MyContext;
	      }
	      
	      @Override
	      public int getCount()
	      {
	    	 /* Set the number of element we want on the grid */
	         return mThumbIds.length;
	      }

	      @Override
	      public View getView(int position, View convertView, ViewGroup parent){
	          // TODO Auto-generated method stub
	          View v;
	          if(convertView==null)
	          {
	              LayoutInflater li = getLayoutInflater();
	              v = li.inflate(R.layout.grid_item, null);
	          }else{
	              v = convertView;
	          }
	          TextView tv = (TextView)v.findViewById(R.id.grid_item_text);
	          tv.setText(categorias[position]);
	          ImageView iv = (ImageView)v.findViewById(R.id.grid_item_image);
	          iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
	          iv.setPadding(-5, -5, -5, -5);
	          iv.setImageResource(mThumbIds[position]);

	          return v;
	      }
	     /* public View getView(int position, View convertView, ViewGroup parent)
	      {
	         View MyView = convertView;
	         
	         if ( convertView == null )
	         {
	                                //we define the view that will display on the grid
	            
	            //Inflate the layout
	            LayoutInflater li = getLayoutInflater();
	            MyView = li.inflate(R.layout.grid_item, null);
	            
	            // Add The Text!!!
	            TextView tv = (TextView)MyView.findViewById(R.id.grid_item_text);
	            tv.setText(categorias[position]);
	            
	            // Add The Image!!!   
	            
	            ImageView iv = (ImageView)MyView.findViewById(R.id.grid_item_image);
	            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            iv.setPadding(-5, -5, -5, -5);
	            iv.setImageResource(mThumbIds[position]);
	         }
	         
	         return MyView;
	      }*/
	      private String[] categorias = {"Albercas","Arquitectos","Baños",
	    		  "Carpinteria","Cocheras","Cocinas","Decoracion","Electrico",
	    		  "Fumigacion","Granito","Industrial","Limpieza","Malla",
	    		  "Paisajismo","Persianas","Concreto","Pisos","Plomeria","Puertas","Riego","Seguridad",
	    		  "Viveros"};
		    private Integer[] mThumbIds = {
		            R.drawable.albercas,
		            R.drawable.arquitectos,
		            R.drawable.banos,
		            R.drawable.carpinteria,
		            R.drawable.cocheras,
		            R.drawable.cocinas,
		            R.drawable.decoracion,
		            R.drawable.electrico,
		            R.drawable.fumigacion,
		            R.drawable.granito,
		            R.drawable.indutrial,
		            R.drawable.limpieza,
		            R.drawable.malla,
		            R.drawable.paisajismo,
		            R.drawable.persianas,
		            R.drawable.pisoconcreto,
		            R.drawable.pisos,
		            R.drawable.plomeria,
		            R.drawable.puertas,
		            R.drawable.riego,
		            R.drawable.seguridad,
		            R.drawable.viveros    
		    };

	      @Override
	      public Object getItem(int arg0) {
	         // TODO Auto-generated method stub
	         return null;
	      }

	      @Override
	      public long getItemId(int arg0) {
	         // TODO Auto-generated method stub
	         return 0;
	      }
	   }
       public void AbrirExplorador(String pos){
	   Intent intent = new Intent(MainTabla.this, Explorador.class);
       intent.putExtra("posicion", pos);
       startActivity(intent);
       }
   	public void Aviso(){
		Toast.makeText(MainTabla.this, "Directorio Vacio" , Toast.LENGTH_SHORT).show();
   	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_tabla, menu);
		return true;
	}

}
