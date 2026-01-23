import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './RecommendationSystem.css';

const RecommendationSystem = () => {
  const [recommendations, setRecommendations] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchRecommendations();
  }, []);

  const fetchRecommendations = async () => {
    try {
      const response = await axios.get('/api/recommendations');
      setRecommendations(response.data);
      setLoading(false);
    } catch (err) {
      setError('Failed to fetch recommendations');
      setLoading(false);
    }
  };

  if (loading) return <div className="loading">Loading recommendations...</div>;
  if (error) return <div className="error">{error}</div>;

  return (
    <div className="recommendation-container">
      <h2>Recommended Properties</h2>
      <div className="recommendation-grid">
        {recommendations.map((recommendation) => (
          <div key={recommendation.id} className="recommendation-card">
            <img src={recommendation.imageUrl} alt={recommendation.title} />
            <div className="recommendation-content">
              <h3>{recommendation.title}</h3>
              <p className="location">{recommendation.location}</p>
              <p className="price">₹{recommendation.price}/month</p>
              <div className="features">
                <span>{recommendation.bedrooms} Beds</span>
                <span>{recommendation.bathrooms} Baths</span>
                <span>{recommendation.area} sq ft</span>
              </div>
              <button className="view-details-btn">View Details</button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default RecommendationSystem; 